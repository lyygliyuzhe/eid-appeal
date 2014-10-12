/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import java.util.List;
import org.iie.dao.basedao.BaseDao;
import org.iie.po.LwbData;
import org.iie.service.LwbStatisticsService;
import org.iie.vo.KeyWordCollectInfoDto;

/**
 *
 * @author zmc
 */
public class LwbStatisticsServiceImpl implements LwbStatisticsService {

      private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int getForwardData(String hql) {
        List<LwbData> LwbDataList = baseDao.find(hql);
        return LwbDataList.size();
    }

    @Override
    public KeyWordCollectInfoDto getKeyWordCollectInfo(String keyword) {
        KeyWordCollectInfoDto keyWordCollectInfo = new KeyWordCollectInfoDto();
//        QuerySearch querySearch = new QuerySearch();
//        keyWordCollectInfo.setText(keyword);
//        ArrayList<String> list = new ArrayList<String>();
//        String[] tempStr = {keyword};
//        try {
//            list = querySearch.search(tempStr);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        keyWordCollectInfo.setWeight(list.size());
        return keyWordCollectInfo;
    }

}
