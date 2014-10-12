/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import java.util.List;
import org.iie.vo.KeyWordCollectInfoDto;
import org.iie.vo.Pager;

/**
 *
 * @author fenglei
 */
public interface LwbStatisticsService {

    public int getForwardData(String hql);

    public KeyWordCollectInfoDto getKeyWordCollectInfo(String keyword);

}
