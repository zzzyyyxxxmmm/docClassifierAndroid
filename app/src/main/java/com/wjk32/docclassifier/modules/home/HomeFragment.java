package com.wjk32.docclassifier.modules.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wjk32.docclassifier.R;
import com.wjk32.docclassifier.base.BaseFragment;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by Jikang Wang on 11/16/18.
 */
public class HomeFragment extends BaseFragment implements HomeContract.View {


    private HomeContract.Presenter mPresenter;

    @BindView(R.id.title)
    TextView mTextView;

    @BindView(R.id.words)
    EditText mEditText;

    @BindView(R.id.predict_button)
    Button mPredictButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);
    }

    void initView() {
        mEditText.setText("586242498a88 9ccf259ca087 54709b24b45f 6bf9c0cb01b4 3486e5fe0d73 c337a85b8ef9 b2125dcdb706 f1424da4e7d6 5defc9f531f0 7ec02e30a5b3 f9e92c0357ef 6753b57205cb 5488cb2c0749 1ec85e7e2142 2685f0879380 b2125dcdb706 f1424da4e7d6 5defc9f531f0 b834a58b85b9 036087ac04f9 2bcce4e05d9d 6ca2dd348663 d38820625542 c9a53ea6e219 6dae7d5c1d03 1aba273fa8e4 0d66aace12f3 b6670dfb5ae7 5be138559904 b2125dcdb706 f1424da4e7d6 5defc9f531f0 b834a58b85b9 036087ac04f9 b136f6349cf3 186c2a8b23eb 7772cb33d419 e943e5e5b779 7a5e719bafba cbfb3eb99bea d38820625542 9287e6d15453 c85a9f2e0024 1c303d15eb65 351248ac109a 5ee06767bc0f ed1e3242ee34 cc27fc4409a9 4ce4bfb42e22 63e05aeec02b b9699ce57810 641356219cbc b2125dcdb706 f1424da4e7d6 5defc9f531f0 831d93352e04 21e314d3afcc ebbd827fe2a0 641356219cbc 422068f04236 d19b1c129f40 b9699ce57810 b834a58b85b9 f0666bdbc8a5 036087ac04f9 eeb86a6a04e4 2bcce4e05d9d 48d657cd9861 b643c02ad43a 831d93352e04 21e314d3afcc 2e182c67811b 641356219cbc d19b1c129f40 6ca2dd348663 831d93352e04 21e314d3afcc d38820625542 6bf9c0cb01b4 3486e5fe0d73 c337a85b8ef9 c9a53ea6e219 f7ae6f8257da 6dae7d5c1d03 b2125dcdb706 ecee69844b4e f1424da4e7d6 36e7aa72ffe1 5defc9f531f0 0302af775b89 7e0ebc43dbc1 1015893e384a 28ddf393019c 586242498a88 54709b24b45f 7ec02e30a5b3 5fa62998872f f9e92c0357ef 9f11111004ec 0ad17934ee05 c337a85b8ef9 be9f9e5522c9 446c804d79cc 6753b57205cb f7ae6f8257da eeb86a6a04e4 586242498a88 641356219cbc 446c804d79cc 5488cb2c0749 eeb86a6a04e4 1ec85e7e2142 25c57acdf805 4e9eb063e763 25c57acdf805 54709b24b45f de150c7d4218 641356219cbc ce1f034abb5d c3069551abe0 6bff0c8c1185 4df68bb4c0fe a20e78c41cf9 5e99d31d8fa4 a5f8a7c9a886 93790ade6682 4357c81e10c1 06e7c4534cb7 a31962fbd5f3 54709b24b45f b61f1af56200 6365c4563bd1 641356219cbc 446c804d79cc 97b6014f9e50 b3321da48f0d 2ef7c27a5df4 93c988b67c47 2bcce4e05d9d e67eb757a353 ff1c26ea0b6f 3d877a3bc4f0 0226fe922dd0 dec250bd255f 2556150a673a 2bcce4e05d9d 9bc65adc033c e0a34e168ea4 376aa3d8142d 036087ac04f9 2bcce4e05d9d e43c4b6f2c61 831d93352e04 21e314d3afcc 641356219cbc d19b1c129f40 26f768da5068 aed969aac7a8 6bf9c0cb01b4 3486e5fe0d73 c337a85b8ef9 b9699ce57810 641356219cbc 6bf9c0cb01b4 3486e5fe0d73 1b6d0614f2c7 6bf9c0cb01b4 3486e5fe0d73 c337a85b8ef9 c9a53ea6e219 6dae7d5c1d03 878460b4304e 133d46f7ed38 43af6db29054 7c19789847e6 7e0ebc43dbc1 de9738ee8b24 1015893e384a 586242498a88 e43c4b6f2c61 eeb86a6a04e4 641356219cbc 446c804d79cc f95d0bea231b aa1ef5f5355f" );
        mPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getLabel(mEditText.getText().toString());
                Log.e("URL", "666" );
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.predict_fragment, container, false);
        ButterKnife.bind(this, root);
        initView();
        return root;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLabel(String s) {
        Toast.makeText(getActivity(), "Result= " + s, Toast.LENGTH_LONG).show();
    }
}
