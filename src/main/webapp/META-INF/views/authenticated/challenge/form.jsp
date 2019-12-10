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

<%@page import="java.util.Locale"%>
<%@page import="acme.features.authenticated.challenge.AuthenticatedChallengeShowService"%>
<%@page import="acme.features.authenticated.challenge.AuthenticatedChallengeListService"%>
<%@page import="acme.framework.entities.Authenticated"%>
<%@page import="acme.entities.challenges.Challenge"%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title" />
	<acme:form-moment code="authenticated.challenge.form.label.deadline" path="deadline" />
	<acme:form-textbox code="authenticated.challenge.form.label.description" path="description" />


<table border="1" >
	
<tr><th> <acme:message code="authenticated.challenge.form.label.goals" /></th> <th><acme:message code="authenticated.challenge.form.label.rewards" /></th></tr>
	
	
	 <tr><th colspan="2" align="center"><acme:message code="authenticated.challenge.form.label.gold" /></th></tr>
		<tr>
    		<td><acme:form-textbox code="" path="goldEn" /></td><td><acme:form-double code="" path="rewardGold" /> </td>
 		 </tr>
		<tr><th colspan="2" align="center"><acme:message code="authenticated.challenge.form.label.silver" /></th></tr>
		<Tr>
			<td><acme:form-textbox code="" path="silverEn"  /> </td><td><acme:form-double code="" path="rewardSilver" /> </td>
		</tr>
		<tr><th colspan="2" align="center"><acme:message code="authenticated.challenge.form.label.bronze" /></th></tr>
		<tr>
			<td><acme:form-textbox code="" path="bronzeEn" /></td><td><acme:form-double code="" path="rewardBronze" /> </td>
		</tr>
		
	
	
	</table>
	<br> 
 

 

	<acme:form-return code="authenticated.challenge.form.button.return" />
</acme:form>
