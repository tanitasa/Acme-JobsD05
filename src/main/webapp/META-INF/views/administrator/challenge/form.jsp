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
<%@page import="java.util.Locale"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>



<%-- <%=   Locale.getDefault().toString() %> --%>
 
<c:set var="locale" value="<%=  Locale.getDefault().toString() %>"/>

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title" />
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline" />
	<acme:form-textbox code="administrator.challenge.form.label.description" path="description" />


 <table border="1" >
	
<tr><th> <acme:message code="administrator.challenge.form.label.goals" /></th> <th><acme:message code="administrator.challenge.form.label.rewards" /></th></tr>
	
	
	 <tr><th colspan="2" align="center"><acme:message code="administrator.challenge.form.label.gold" /></th></tr>
		<tr>
    		<td><acme:form-textbox code="" path="goldEn" /></td><td><acme:form-double code="" path="rewardGold" /> </td>
 		 </tr>
		<tr><th colspan="2" align="center"><acme:message code="administrator.challenge.form.label.silver" /></th></tr>
		<Tr>
			<td><acme:form-textbox code="" path="silverEn"  /> </td><td><acme:form-double code="" path="rewardSilver" /> </td>
		</tr>
		<tr><th colspan="2" align="center"><acme:message code="administrator.challenge.form.label.bronze" /></th></tr>
		<tr>
			<td><acme:form-textbox code="" path="bronzeEn" /></td><td><acme:form-double code="" path="rewardBronze" /> </td>
		</tr>
		
	
	
	</table>
	<br> 
 
 <acme:form-submit test="${command == 'show'}"
		code = "administrator.challenge.form.button.update"
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show'}"
		code = "administrator.challenge.form.button.delete"
		action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code = "administrator.challenge.form.button.create"
		action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'update'}"
		code = "administrator.challenge.form.button.update"
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code = "administrator.challenge.form.button.delete"
		action="/administrator/challenge/delete"/>

 

	<acme:form-return code="administrator.challenge.form.button.return" />
</acme:form>
	
	
	
