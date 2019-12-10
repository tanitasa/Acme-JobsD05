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
	<acme:list-column code="authenticated.companyRecord.list.label.name" width="5%" path="name"/>
	<acme:list-column code="authenticated.companyRecord.list.label.sector" width="5%" path="sector"/>
	<acme:list-column code="authenticated.companyRecord.list.label.ceoName" width="5%" path="ceoName"/>
	<acme:list-column code="authenticated.companyRecord.list.label.description" width="5%" path="description"/>
	<acme:list-column code="authenticated.companyRecord.list.label.web" width="5%" path="web"/>
	<acme:list-column code="authenticated.companyRecord.list.label.phoneNumber" width="5%" path="phoneNumber"/>
	<acme:list-column code="authenticated.companyRecord.list.label.email" width="5%" path="email"/>
	<acme:list-column code="authenticated.companyRecord.list.label.isIncorporated" width="5%" path="isIncorporated"/>
	<acme:list-column code="authenticated.companyRecord.list.label.stars" width="5%" path="stars"/>
	
	
</acme:list>
