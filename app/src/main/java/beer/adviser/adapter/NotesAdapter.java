package beer.adviser.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {


    @NonNull
    @Override
    public NotesAdapter.BeanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.BeanHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public BeanHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
