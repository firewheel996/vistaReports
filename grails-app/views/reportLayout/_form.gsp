<%@ page import="org.ohiocdc.ReportLayout" %>



<div class="fieldcontain ${hasErrors(bean: reportLayoutInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="reportLayout.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" min="2014" value="${reportLayoutInstance.year}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportLayoutInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="reportLayout.questions.label" default="Questions" />
		
	</label>
	<g:select name="questions" from="${org.ohiocdc.Question.list()}" multiple="multiple" optionKey="id" size="5" value="${reportLayoutInstance?.questions*.id}" class="many-to-many"/>
</div>

