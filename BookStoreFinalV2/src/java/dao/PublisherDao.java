/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Publisher;
import java.util.List;

/**
 *
 * @author ngocv
 */
public interface PublisherDao {

    public List<Publisher> getAllPublishers();

    public String getNamePublisherById(String id);

    public Publisher getPublisherById(String id);

    public Boolean insertPublisher(Publisher pub);

    public Boolean updatePublisher(Publisher pub);

    public Boolean deletePublisher(String id);

}
