package pe.edu.upc.fitnow.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.fitnow.Interface.ItemClickListener;
import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.model.Exercice;

/**
 * Created by mac on 11/15/17.
 */

public class ExercicesAdapter extends RecyclerView.Adapter<ExercicesAdapter.ViewHolder> {

    private List<Exercice> exercicess;
    private List<Exercice> checkedExercicess;

    public ExercicesAdapter() {
    }

    public ExercicesAdapter(List<Exercice> exercicess) {this.setExercicess(exercicess);}

    public List<Exercice> getExercicess() {
        return exercicess;
    }
    public ExercicesAdapter setExercicess(List<Exercice> exercicess) {
        this.exercicess = exercicess;
        return this;
    }

    @Override
    public ExercicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_exercice,parent,false);
        ExercicesAdapter.ViewHolder holder= new ExercicesAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ExercicesAdapter.ViewHolder holder, int position) {
        final Exercice exercice = exercicess.get(position);
        holder.exerciceANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.exerciceANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.exerciceANImageView.setImageUrl(exercice.getImage());
        holder.nameTextView.setText(exercice.getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox cb = (CheckBox) v;
                if(cb.isChecked()){
                    checkedExercicess.add(exercicess.get(pos));
                }else {
                    checkedExercicess.remove(exercicess.get(pos));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return null != exercicess ? exercicess.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ANImageView exerciceANImageView;
        TextView nameTextView;
        CheckBox cbCheckBox;


        ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            exerciceANImageView = (ANImageView) itemView.findViewById(R.id.exerciceANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameexercicesTextView);
            cbCheckBox = (CheckBox) itemView.findViewById(R.id.CbCheckBox);

            cbCheckBox.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;
        }
        //no se que hace esta weada
        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }
    }
}
