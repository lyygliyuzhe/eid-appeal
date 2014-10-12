/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import java.util.List;
import org.iie.po.LwbSpread;

/**
 *
 * @author zmc
 */
public interface LwbSpreadService {

    public List<LwbSpread> getAll();

    public void save(LwbSpread lwbSpread);

    public void delete(int id);
}
