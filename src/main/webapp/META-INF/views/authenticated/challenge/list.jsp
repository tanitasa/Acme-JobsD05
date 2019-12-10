<%--
- list.jsp
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
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<acme:list>
	<acme:list-column code="authenticated.challenge.list.label.title"  width="5%"  path="title"/>
	<acme:list-column code="authenticated.challenge.list.label.deadline"  width="5%"  path="deadline"/>
	<acme:list-column code="authenticated.challenge.list.label.description"  width="5%" path="description"/>
	
	<c:if test="${Locale.getDefault().toString()=='en'}">
	<acme:list-column code="administrator.challenge.form.label.gold" width="5%"  path="goldEn"/>
	<acme:list-column code="administrator.challenge.form.label.rewardGold" width="5%"  path="rewardGold"/>
	
	<acme:list-column code="administrator.challenge.form.label.silver" width="5%"  path="silverEn"/>
	<acme:list-column code="administrator.challenge.form.label.rewardSilver" width="5%"  path="rewardSilver"/>
	
	
	<acme:list-column code="administrator.challenge.form.label.bronze" width="5%"  path="bronzeEn"/>
	<acme:list-column code="administrator.challenge.form.label.rewardBronze" width="5%"  path="rewardBronze"/>
	</c:if>
	
	<c:if test="${Locale.getDefault().toString()=='es'}">
	<acme:list-column code="administrator.challenge.form.label.goals" width="5%"  path="goldEs"/>
	<acme:list-column code="administrator.challenge.form.label.rewards" width="5%"  path="rewardGold"/>
	
	<acme:list-column code="administrator.challenge.form.label.goals" width="5%"  path="silverEs"/>
	<acme:list-column code="administrator.challenge.form.label.rewards" width="5%"  path="rewardSilver"/>
	
	
	<acme:list-column code="administrator.challenge.form.label.goals" width="5%"  path="bronzeEs"/>
	<acme:list-column code="administrator.challenge.form.label.rewards" width="5%"  path="rewardBronze"/>
	</c:if>

</acme:list>
