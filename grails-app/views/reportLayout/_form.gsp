<%@ page import="org.ohiocdc.ReportLayout" %>



<div class="fieldcontain ${hasErrors(bean: reportLayoutInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="reportLayout.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" min="2014" value="${reportLayoutInstance.year}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportLayoutInstance, field: 'questions', 'error')} required">
	<label for="questions">
		<g:message code="reportLayout.questions.label" default="Questions" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

