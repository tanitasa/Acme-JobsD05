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

<acme:list>
	<acme:list-column code="authenticated.offer.list.label.ticker" width="10%" path="ticker"/>
	<acme:list-column code="authenticated.offer.list.label.title" width="10%" path="title"/>
	<acme:list-column code="authenticated.offer.list.label.creationMoment" width="20%" path="creationMoment"/>
	<acme:list-column code="authenticated.offer.list.label.deadline" width="20%" path="deadline"/>
	<acme:list-column code="authenticated.offer.list.label.description" width="20%" path="description"/>
	<acme:list-column code="authenticated.offer.list.label.minReward" width="10%" path="minReward"/>
	<acme:list-column code="authenticated.offer.list.label.maxReward" width="10%" path="maxReward"/>
</acme:list>
