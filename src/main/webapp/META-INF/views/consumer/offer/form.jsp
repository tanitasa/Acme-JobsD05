<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<acme:form>
	<acme:form-textbox code="consumer.offer.form.label.ticker" path="ticker"/>
	<acme:form-textbox code="consumer.offer.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="consumer.offer.form.label.creationMoment" path="creationMoment"
		readonly="true"/>
	</jstl:if>
	<acme:form-moment code="consumer.offer.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="consumer.offer.form.label.description" path="description"/>
	<acme:form-double code="consumer.offer.form.label.minReward" path="minReward"/>
	<acme:form-double code="consumer.offer.form.label.maxReward" path="maxReward"/>
	
	<div class="form-group">
	<div class="form-check">
		<input id="acceptL" required="required" name="acceptL" type="checkbox" class="form-check-input"
			<jstl:if test="${requestScope[accept] == 'true'}">
				checked
			</jstl:if>/> 
		<input id="accept" name="accept" type="hidden" value="<jstl:out value="${requestScope[accept]}"/>"/> 
		<label for="acceptL"> 
			<spring:message	code="consumer.offer.label.accept"/>
		</label>
	</div>
	<acme:form-errors path="${accept}"/>
	</div>
	<acme:form-submit test="${command == 'create'}"
	code="consumer.offer.form.button.create" action="/consumer/offer/create"/>
	
	<acme:form-return code="consumer.offer.form.button.return"/>
</acme:form>
