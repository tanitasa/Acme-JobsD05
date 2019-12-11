<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-tania" action="https://www.infojobs.net/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-carlos" action="https://biwenger.as.com/"/>
     		<acme:menu-suboption code="master.menu.anonymous.favourite-link-gonzalo" action="https://www.amazon.es/"/>
      		<acme:menu-suboption code="master.menu.anonymous.favourite-link-damian" action="https://www.github.com/"/>
      		<acme:menu-suboption code="master.menu.anonymous.favourite-link-victor" action="https://www.youtube.com/"/>
      		<acme:menu-suboption code="master.menu.anonymous.companyRecords.list" action="/anonymous/company-record/list"/>
      		<acme:menu-suboption code="master.menu.anonymous.investorRecords.list" action="/anonymous/investor-record/list"/>
      		<acme:menu-suboption code="master.menu.anonymous.announcement.list" action="/anonymous/announcement/list"/>		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.requests.list" action="/authenticated/requests/list"/>
			<acme:menu-suboption code="master.menu.authenticated.offers.list" action="/authenticated/offer/list"/>
			<acme:menu-suboption code="master.menu.authenticated.challenges.list" action="/authenticated/challenge/list"/>
			<acme:menu-suboption code="master.menu.authenticated.companyRecords.list" action="/authenticated/company-record/list"/>
			<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.investorRecords.list" action="/authenticated/investor-record/list"/>
		    <acme:menu-suboption code="master.menu.authenticated.job.list" action="/authenticated/job/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.list" action="/administrator/announcement/list"/>	
			<acme:menu-suboption code="master.menu.administrator.companyRecords.list" action="/administrator/company-record/list"/>
			<acme:menu-suboption code="master.menu.administrator.investorRecords.list" action="/administrator/investor-record/list"/>
			<acme:menu-suboption code="master.menu.administrator.challenges.list" action="/administrator/challenge/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.companyRecords.create" action="/administrator/company-record/create"/>
			<acme:menu-suboption code="master.menu.administrator.investorRecords.create" action="/administrator/investor-record/create"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create"/>
			<acme:menu-suboption code="master.menu.administrator.challenges.create" action="/administrator/challenge/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
<acme:menu-suboption code="master.menu.provider.requests.create" action="/provider/requests/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
			<acme:menu-suboption code="master.menu.employer.jobs" action="/employer/job/list"/>
			<acme:menu-suboption code="master.menu.employer.application.list" action="/employer/application/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.consumer.offers.create" action="/consumer/offer/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.applications" action="/worker/application/list"/>
		</acme:menu-option>
		
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create" access="!hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update" access="hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create" access="!hasRole('Worker')"/>
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update" access="hasRole('Worker')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>