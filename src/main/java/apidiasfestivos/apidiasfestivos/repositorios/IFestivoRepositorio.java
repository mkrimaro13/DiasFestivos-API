package apidiasfestivos.apidiasfestivos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import apidiasfestivos.apidiasfestivos.entidades.Festivo;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Long> {
}
