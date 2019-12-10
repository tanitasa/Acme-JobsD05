
package acme.features.authenticated.announcement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAnnouncementListService implements AbstractListService<Authenticated, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAnnouncementRepository repository;


	// AbstractListService<Authenticated, Request> interface ---------------

	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "link", "description");
	}

	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;
		Collection<Announcement> result = new ArrayList<Announcement>();
		Collection<Announcement> aux;

		aux = this.repository.findManyAll();

		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, -1);

		for (Announcement a : aux) {
			if (!a.getCreationMoment().before(calendar.getTime())) {
				result.add(a);
			}
		}

		return result;
	}

}
