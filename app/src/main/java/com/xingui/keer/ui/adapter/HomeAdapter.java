package com.xingui.keer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xingui.keer.R;

import java.util.List;

/**
 * =============================================
 * 作者： Lizh on 2017/7/25.
 * 描述：
 * ============================================
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> mDatas;
    private int[] imageId = new int[] {  R.mipmap.image1,
                                            R.mipmap.image2,
                                            R.mipmap.image3,
                                            R.mipmap.image4,
                                            R.mipmap.image5,
                                            R.mipmap.image6,
                                            R.mipmap.image7,
                                            R.mipmap.image8};

    public HomeAdapter(Context context, List<String> mDatas) {
        this.inflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        itemHolder.tvAcceptTime.setText(mDatas.get(position));
        itemHolder.id_img.setImageResource(imageId[position]);
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAcceptTime;
        private ImageView id_img;
        public ViewHolder(View itemView) {
            super(itemView);
            tvAcceptTime = (TextView) itemView.findViewById(R.id.id_num);
            id_img = (ImageView) itemView.findViewById(R.id.id_img);
        }
    }
}
