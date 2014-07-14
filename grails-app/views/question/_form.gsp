<%@ page import="org.ohiocdc.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="question.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${questionInstance?.question}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'answerFormat', 'error')} ">
	<label for="answerFormat">
		<g:message code="question.answerFormat.label" default="Answer Format" />
		
	</label>
	<g:select name="answerFormat" from="${questionInstance.constraints.answerFormat.inList}" value="${questionInstance?.answerFormat}" valueMessagePrefix="question.answerFormat" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'uses', 'error')} ">
	<label for="uses">
		<g:message code="question.uses.label" default="Uses" />
		
	</label>
	
</div>

