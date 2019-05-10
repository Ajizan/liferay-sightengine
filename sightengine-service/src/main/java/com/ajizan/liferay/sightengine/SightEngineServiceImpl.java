package com.ajizan.liferay.sightengine;

import com.ajizan.liferay.sightengine.api.SightEngineService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author aiziki
 */
@Component(immediate = true, property = {}, service = SightEngineService.class, configurationPid = "com.ajizan.liferay.sightengine.SightEngineConf")
public class SightEngineServiceImpl implements SightEngineService {
	private static Log _log = LogFactoryUtil.getLog(SightEngineServiceImpl.class);

	@Override
	public boolean isSafeImage(File file) {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			HttpEntity data = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
					.addBinaryBody("media", file, ContentType.DEFAULT_BINARY, file.getName())
					.addTextBody("api_user", _config.getApiUser(), ContentType.TEXT_PLAIN)
					.addTextBody("api_secret", _config.getApiSecret(), ContentType.TEXT_PLAIN)
					.addTextBody("models", String.join(",", _config.getModels()), ContentType.TEXT_PLAIN).build();

			HttpUriRequest request = RequestBuilder.post(_config.getUrl()).setEntity(data).build();

			if (_log.isDebugEnabled()) {
				_log.debug("Executing request " + request.getRequestLine());
			}

			// Create a custom response handler
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			String responseBody = httpclient.execute(request, responseHandler);
			if (_log.isDebugEnabled()) {
				_log.debug(responseBody);
			}
			JSONObject result = JSONFactoryUtil.createJSONObject(responseBody);
			double alcohol = result.getDouble("alcohol");
			double weapon = result.getDouble("weapon");
			double drugs = result.getDouble("drugs");
			//double offensive = (result.getJSONObject("offensive")).getDouble("prob");
			double offensive = 0;

			JSONObject nudity = result.getJSONObject("nudity");

			double raw = nudity.getDouble("raw");
			double partial = nudity.getDouble("partial");
			
			_log.debug(result);

			double maximum = Math.max(Math.max(Math.max(alcohol, drugs), Math.max(offensive, weapon)),
					Math.max(partial, raw));

			if (maximum > _config.getThreshold()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			_log.error(e);
		}
		return false;

	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_config = ConfigurableUtil.createConfigurable(SightEngineServiceConfiguration.class, properties);
	}

	public volatile SightEngineServiceConfiguration _config;
}