/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import za.ac.cput.school_management.domain.City;


import za.ac.cput.school_management.factory.CityFactory;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

import static java.util.spi.ToolProvider.findFirst;
import static org.springframework.cglib.core.CollectionUtils.filter;



public class CityRepositoryImpl implements ICityRepository {

    private final List<City> cityListList;

    private static ICityRepository ICITY_REPOSITORY;

    private CityRepositoryImpl(){this.cityListList = new ArrayList<>();}

    public static ICityRepository getIcityRepository(){
        if(ICITY_REPOSITORY== null)
            ICITY_REPOSITORY = new CityRepositoryImpl();
        return ICITY_REPOSITORY;
    }
    @Override
    public City save (City city){
       City.Builder cityId =
                CityFactory.buildById(city);
        Optional<City> read = read(city);
        if(read.isPresent()){
            delete(read.get());
        }
        this.cityListList.add(city);
        return city;
    }
    @Override
    public Optional<City> read(City cityId){
        return this.cityListList.stream()
                .filter(name -> cityId.getName().equalsIgnoreCase(name));
        filter(id -> cityId.getId().equalsIgnoreCase(id));
        filter(country -> cityId.getCountry().equalsIgnoreCase(country));
        findFirst();
    }
    @Override
    public void delete(City city){
     this.cityListList.remove(cityListList);

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends City> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<City> findByEmployeeNumber(String city){
        return this.cityListList;
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public List<City> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<City> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public <S extends City> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<City> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends City> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends City> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<City> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public City getOne(String s) {
        return null;
    }

    @Override
    public City getById(String s) {
        return null;
    }

    @Override
    public City getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends City> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends City> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends City> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends City> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends City> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends City> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends City, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
