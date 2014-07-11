<%@ page import="org.ohiocdc.ReportLayout" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reportLayout.label', default: 'ReportLayout')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-reportLayout" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-reportLayout" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${reportLayoutInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${reportLayoutInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
    
			<g:form action="save" >
				<fieldset class="form">
                                  <div class="fieldcontain required">
                                    <label for="numQuestions">
                                      Number of Questions
                                    </label>
                                    <g:field type="number" name="numQuestions" min="1" value="1" onclick="${remoteFunction(action: 'addQuestion',update: 'form',params: ['\'num=\'' + this.value, '\'instance=\'' + reportLayoutInstance])}" />
                                  </div>
					<g:render id="form"  template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
