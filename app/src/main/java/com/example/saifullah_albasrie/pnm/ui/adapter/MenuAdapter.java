package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.MenuModel;
import com.example.saifullah_albasrie.pnm.model.annotation.MenuType;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.ui.viewholder.ButtonAddViewHolder;
import com.example.saifullah_albasrie.pnm.ui.viewholder.ButtonViewHolder;
import com.example.saifullah_albasrie.pnm.ui.viewholder.JaminanViewHolder;
import com.example.saifullah_albasrie.pnm.ui.viewholder.MenuViewHolder;
import com.example.saifullah_albasrie.pnm.ui.viewholder.SurveyViewHolder;

import java.util.List;

/**
 * Created by saifullah_albasrie on 4/4/17.
 */

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener onClickListener;

    private List<MenuModel> list;

    public MenuAdapter(List<MenuModel> list) {
        this.list = list;
    }

    public MenuModel getSelectedItem(int position) {
        return list.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == MenuType.SURVEY_MENU) {
            return getSurveyMenuHolder(inflater, parent);
        } else if (viewType == MenuType.BUTTON_MENU) {
            return getButtonMenuHolder(inflater, parent);
        } else if (viewType == MenuType.BUTTON_ADD) {
            return getButtonAddHolder(inflater, parent);
        } else if (viewType == MenuType.SUB_MENU) {
            return getSubMenuViewHolder(inflater, parent);
        } else if (viewType == MenuType.JAMINAN_MENU) {
            return getJaminanMenuHolder(inflater, parent);
        } else {
            return getMenuViewHolder(inflater, parent);
        }

    }

    private RecyclerView.ViewHolder getSurveyMenuHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_menu_survey, parent, false);
        SurveyViewHolder viewHolder = new SurveyViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    private RecyclerView.ViewHolder getButtonMenuHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_menu_button, parent, false);
        ButtonViewHolder viewHolder = new ButtonViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    private RecyclerView.ViewHolder getButtonAddHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_menu_button_add, parent, false);
        ButtonAddViewHolder viewHolder = new ButtonAddViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    private RecyclerView.ViewHolder getSubMenuViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_menu_navigation2, parent, false);
        MenuViewHolder viewHolder = new MenuViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    private RecyclerView.ViewHolder getMenuViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_menu_navigation1, parent, false);
        MenuViewHolder viewHolder = new MenuViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    private RecyclerView.ViewHolder getJaminanMenuHolder(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_jaminan_menu, parent, false);
        JaminanViewHolder viewHolder = new JaminanViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            boolean isLastItem = position == list.size() - 1;
            MenuModel model = list.get(position);
            if (model.getType() == MenuType.SURVEY_MENU && holder instanceof SurveyViewHolder) {
                SurveyViewHolder newHolder = (SurveyViewHolder) holder;
                newHolder.tvSubItemSurvey.setText(model.getLabel());
                if (model.getStatus() == 1) {
                    //newHolder.mContainer.setBackgroundColor(mContext.getResources().getColor(R.color.light_green));
                    newHolder.mContainer.setBackgroundResource(R.drawable.button_green_selector);
                    newHolder.ivStatusSurvey.setImageResource(R.drawable.ic_checkmark);
                } else {
                    //newHolder.mContainer.setBackgroundColor(mContext.getResources().getColor(R.color.grey_light));
                    newHolder.mContainer.setBackgroundResource(R.drawable.button_lightgrey_selector);
                    newHolder.ivStatusSurvey.setImageResource(R.drawable.ic_delete);
                }
            } else if (model.getType() == MenuType.BUTTON_MENU && holder instanceof ButtonViewHolder) {
                ButtonViewHolder newHolder = (ButtonViewHolder) holder;
                newHolder.btnMenu.setText(model.getLabel());
                if (model.getBackground() != null) {
                    newHolder.btnMenu.setBackgroundDrawable(model.getBackground());
                } else {
                    newHolder.btnMenu.setBackgroundResource(R.drawable.button_grey_selector);
                }

                if (model.getPaddingTop() > 0) {
                    float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, model.getPaddingTop(), mContext.getResources().getDisplayMetrics());
                    newHolder.mContainer.setPadding(newHolder.mContainer.getPaddingLeft(),
                            (int) px,
                            newHolder.mContainer.getPaddingRight(),
                            newHolder.mContainer.getPaddingBottom());
                }

                if (model.getPaddingBottom() > 0) {
                    float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, model.getPaddingBottom(), mContext.getResources().getDisplayMetrics());
                    newHolder.mContainer.setPadding(newHolder.mContainer.getPaddingLeft(),
                            newHolder.mContainer.getPaddingTop(),
                            newHolder.mContainer.getPaddingRight(),
                            (int) px);
                }

                /*if (isLastItem) {
                    newHolder.mContainer.setPadding(newHolder.mContainer.getPaddingLeft(),
                            newHolder.mContainer.getPaddingTop(),
                            newHolder.mContainer.getPaddingRight(),
                            30);
                }*/
            } else if (model.getType() == MenuType.BUTTON_ADD && holder instanceof ButtonAddViewHolder) {
                ButtonAddViewHolder newHolder = (ButtonAddViewHolder) holder;
                newHolder.btnLabel.setText(model.getLabel());
                if (model.getBackground() != null) {
                    newHolder.btnLabel.setBackgroundDrawable(model.getBackground());
                }
                if (isLastItem) {
                    newHolder.mContainer.setPadding(newHolder.mContainer.getPaddingLeft(),
                            newHolder.mContainer.getPaddingTop(),
                            newHolder.mContainer.getPaddingRight(),
                            30);
                }
            } else if (model.getType() == MenuType.SUB_MENU && holder instanceof MenuViewHolder) {
                MenuViewHolder newHolder = (MenuViewHolder) holder;
                newHolder.tvMenu.setText(model.getLabel());
                if (newHolder.ivIcon != null && model.getIcon() != null) {
                    newHolder.ivIcon.setImageDrawable(model.getIcon());
                }
            } else if (model.getType() == MenuType.MAIN_MENU && holder instanceof MenuViewHolder) {
                MenuViewHolder newHolder = (MenuViewHolder) holder;
                newHolder.tvMenu.setText(model.getLabel());
                if (newHolder.ivIcon != null && model.getIcon() != null) {
                    newHolder.ivIcon.setImageDrawable(model.getIcon());
                }
            } else if (model.getType() == MenuType.JAMINAN_MENU && holder instanceof JaminanViewHolder) {
                JaminanViewHolder newHolder = (JaminanViewHolder) holder;
                newHolder.tvSubJaminan.setText(model.getLabel());
                if (model.getBackground() != null) {
                    newHolder.mContainer.setBackgroundDrawable(model.getBackground());
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onClickListener = listener;
    }

    public OnItemClickListener onItemClickListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, View view, int position, long id) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(itemView, view, position, id);
                }
            }

        };
    }


}
