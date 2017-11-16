package pe.edu.upc.fitnow.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.model.Exercice;

/**
 * Created by mac on 11/15/17.
 */

public class ExercicesAdapter extends RecyclerView.Adapter<ExercicesAdapter.ViewHolder> {

    private List<Exercice> exercicess;

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
    }

    @Override
    public int getItemCount() {
        return null != exercicess ? exercicess.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView exerciceANImageView;
        TextView nameTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            exerciceANImageView = (ANImageView) itemView.findViewById(R.id.exerciceANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameexercicesTextView);
        }
    }
}
