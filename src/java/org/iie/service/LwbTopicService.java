/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import java.util.List;
import org.iie.po.LwbTopic;

/**
 *
 * @author zmc
 */
public interface LwbTopicService {

    public List<LwbTopic> getAll();

    public void save(LwbTopic lwbTopic);

    public void delete(int id);
}
