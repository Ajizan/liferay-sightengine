package com.ajizan.liferay.sightengine.portlet.action;

import com.ajizan.liferay.sightengine.api.SightEngineService;
import com.ajizan.liferay.sightengine.constants.MVCCommandNames;
import com.ajizan.liferay.sightengine.constants.SightEnginePortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCCommandCache;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		property = {
				"javax.portlet.name=" + SightEnginePortletKeys.SightEngine,
				"mvc.command.name=" + MVCCommandNames.UPLOAD_IMAGE
		},
		service = MVCActionCommand.class
)
public class UploadImageMVCActionCommand implements MVCActionCommand {

	private static Log _log = LogFactoryUtil.getLog(UploadImageMVCActionCommand.class);
	
	@Reference
	private SightEngineService _sightEngineService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		_log.error("un petit message");
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File image = uploadPortletRequest.getFile("image");
		
		_log.error(image.getName());
		
		_log.error(_sightEngineService.isSafeImage(image));
		
		return false;
	}

}
