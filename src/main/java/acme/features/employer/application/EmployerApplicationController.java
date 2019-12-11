
package acme.features.employer.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/application/")
public class EmployerApplicationController extends AbstractController<Employer, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerApplicationListService					listService;

	@Autowired
	private EmployerApplicationShowService					showService;

	@Autowired
	private EmployerApplicationListByReferenceService		listByReferenceService;

	@Autowired
	private EmployerApplicationListByStatusService			listByStatusService;

	@Autowired
	private EmployerApplicationListByCreationMomentService	listByCreationMomentService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_REFERENCE, BasicCommand.LIST, this.listByReferenceService);
		super.addCustomCommand(CustomCommand.LIST_BY_STATUS, BasicCommand.LIST, this.listByStatusService);
		super.addCustomCommand(CustomCommand.LIST_BY_CREATION_MOMENT, BasicCommand.LIST, this.listByCreationMomentService);
	}

}
