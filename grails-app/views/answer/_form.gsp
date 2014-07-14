<%@ page import="org.ohiocdc.Answer" %>



<div class="fieldcontain ${hasErrors(bean: answerInstance, field: 'answer', 'error')} required">
	<label for="answer">
		<g:message code="answer.answer.label" default="Answer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="answer" required="" value="${answerInstance?.answer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: answerInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="answer.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="question" name="question.id" from="${org.ohiocdc.Question.list()}" optionKey="id" required="" value="${answerInstance?.question?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: answerInstance, field: 'report', 'error')} required">
	<label for="report">
		<g:message code="answer.report.label" default="Report" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="report" name="report.id" from="${org.ohiocdc.Report.list()}" optionKey="id" required="" value="${answerInstance?.report?.id}" class="many-to-one"/>
</div>

