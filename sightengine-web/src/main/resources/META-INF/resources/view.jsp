<%@page import="com.ajizan.liferay.sightengine.constants.MVCCommandNames"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL name="<%=MVCCommandNames.UPLOAD_IMAGE %>" var="uploadImageURL">
</liferay-portlet:actionURL>

<aui:form action="${uploadImageURL}">
	<aui:input name="image" type="file"></aui:input>
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>