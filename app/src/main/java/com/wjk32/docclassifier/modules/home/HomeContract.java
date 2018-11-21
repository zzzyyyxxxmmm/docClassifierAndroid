package com.wjk32.docclassifier.modules.home;

import com.wjk32.docclassifier.base.BasePresenter;
import com.wjk32.docclassifier.base.BaseView;

/**
 * Created by Jikang Wang on 11/16/18.
 */
public interface HomeContract {
    
    interface View extends BaseView<Presenter> {
        void showLabel(String s);
    }


    interface Presenter extends BasePresenter<View> {
        String getLabel(String s);
    }
}
