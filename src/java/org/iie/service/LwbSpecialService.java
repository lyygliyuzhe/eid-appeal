/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import java.util.List;
import org.iie.po.LwbSpecial;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public interface LwbSpecialService {

    public Pager getAll(int page, int rows);

    public void save(LwbSpecial lwbSpecial);

    public void update(LwbSpecial lwbSpecial);

    public void delete(int id);

    public List<LwbSpecial> event();
}
