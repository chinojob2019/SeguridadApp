package pe.com.distriluz.data.repository.datasource.apps;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.model.Apps;

@Singleton
public class AppsDBDataStore implements AppsDataStore {

    private AppsDataMapper mapper;

    @Inject
    public AppsDBDataStore(AppsDataMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Single<Apps> getApps() {
        return Utils.defaultErrorBDSingle();
    }

    @Override
    public Single<Boolean> setDestacado(String idApp, String value) {
        return null;
    }

    @Override
    public Single<Boolean> addContador(String idApp) {
        return null;
    }

    @Override
    public Single<PreguntasResponse> getPreguntasFrecuentes() {
        return Utils.defaultErrorBDSingle();

        /*
        return Single.create(emmiter -> {
            List<PreguntasResponse.PreguntasfrecuentesItem> result = new ArrayList<>();
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(1,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 01"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 02"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 03"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 04"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 05"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 06"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 07"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 08"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 09"));
            result.add(new PreguntasResponse.PreguntasfrecuentesItem(3,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet viverra massa dignissim porta. Nullam vel euismod ligula. Morbi sit amet tempus lorem, ac pulvinar est. Sed et nisl risus. Morbi ac sapien non nisl porttitor pharetra at eu libero. In magna dui, volutpat vitae mi ut, aliquet euismod risus. Sed pretium leo sit amet erat pharetra, sit amet vulputate tortor ultricies. Quisque sed congue mauris. Aenean euismod justo sit amet ligula lacinia porta. Mauris tortor ligula, tristique at condimentum ut, consectetur ac lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consectetur, erat id fermentum feugiat, ligula elit semper nisi, quis dictum odio eros convallis nunc. Morbi magna metus, congue non ultricies nec, pretium id dui. Vestibulum ullamcorper, massa nec convallis sagittis, mi quam consequat est, vel pretium turpis dolor eget ligula.","Pregunta 10"));
            emmiter.onSuccess(result);
        });

       */

    }

    @Override
    public Single<Boolean> addPregunta(String descripcion, int orden, int idEstado) {
        return Utils.defaultErrorBDSingle();
    }

    @Override
    public Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden, int idEstado) {
        return Utils.defaultErrorBDSingle();
    }
}