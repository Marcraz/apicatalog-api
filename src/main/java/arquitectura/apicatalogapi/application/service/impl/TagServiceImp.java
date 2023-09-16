package arquitectura.apicatalogapi.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arquitectura.apicatalogapi.application.service.TagService;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import arquitectura.apicatalogapi.domain.model.Tag;
import arquitectura.apicatalogapi.infrastructure.repository.EndpointRepository;
import arquitectura.apicatalogapi.infrastructure.repository.TagRepository;

@Service
public class TagServiceImp implements TagService {

	String message = "El ID no existe";

	@Autowired
	private TagRepository repository;

	@Autowired
	private EndpointRepository endpointRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Tag> getAllTags() {
		return this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tag> getTagById(int id) {
		Optional<Tag> entityExists = repository.findById(id);
		if (entityExists.isPresent()) {
			return this.repository.findById(id);
		} else {
			throw new IllegalArgumentException(message);
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		Optional<Tag> entityExists = repository.findById(id);
		if (entityExists.isPresent()) {
			Tag tagToDelete = entityExists.get();

			for (Endpoint endpoint : tagToDelete.getEndpoints()) {
				endpoint.getTags().remove(tagToDelete);
			}
			tagToDelete.getEndpoints().clear();

			tagToDelete.getAplicacion().getTags().remove(tagToDelete);

			repository.delete(tagToDelete);
		} else {
			throw new IllegalArgumentException(message);
		}
	}

	@Override
	@Transactional
	public Tag create(Tag tag, Integer idAplicacion, List<Integer> idEndpoints) {
		tag.setAplicacion(new Aplicacion(idAplicacion));
		List<Endpoint> endpoints = endpointRepository.findAllById(idEndpoints);
		tag.setEndpoints(endpoints);
		return this.repository.save(tag);
	}

	@Override
	@Transactional
	public Tag create(Tag tag, Integer idAplicacion) {
		tag.setAplicacion(new Aplicacion(idAplicacion));
		return this.repository.save(tag);
	}

	@Override
	@Transactional
	public Tag update(int id, Tag tag) {
		tag.setId(id);
		Optional<Tag> entityExists = repository.findById(id);
		if (entityExists.isPresent()) {
			Tag entity = entityExists.get();
			entity.setNombre(tag.getNombre());
			return repository.save(entity);
		} else {
			throw new IllegalArgumentException(message);
		}
	}
}
