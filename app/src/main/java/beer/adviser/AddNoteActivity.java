package beer.adviser;

import androidx.appcompat.app.AppCompatActivity;
import beer.adviser.notedb.Note;
import beer.adviser.notedb.Notedatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

public class AddNoteActivity extends AppCompatActivity {

    private TextInputEditText et_title, et_content;
    private Button button;
    private Notedatabase noteDatabase;
    private Note note;
    private boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        button = findViewById(R.id.but_save);

        noteDatabase = Notedatabase.getInstance(AddNoteActivity.this);

        if ((note = (Note)getIntent().getSerializableExtra("note")) !=null){
            getSupportActionBar().setTitle("Update Note");
            update = true;
            button.setText("Update");
            et_title.setText(note.getTitle());
            et_content.setText(note.getContent());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (update){
                    note.setContent(et_content.getText().toString());
                    note.setTitle(et_title.getText().toString());
                    noteDatabase.getNoteDao().updateNote(note);
                    setResult(note,2);
                }else {
                    note = new Note(et_content.getText().toString(),et_title.getText().toString());
                    new InsertTask(AddNoteActivity.this,note).execute();
                }
            }
        });
    }

    private void setResult(Note note,int flag){
        setResult(flag,new Intent().putExtra("note", (Parcelable) note));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void,Void,Boolean>{

        private WeakReference<AddNoteActivity> activityReference;
        private Note note;

        InsertTask(AddNoteActivity context,Note note){
            activityReference = new WeakReference<>(context);
            this.note = note;
        }

        @Override
        protected Boolean doInBackground(Void... objs) {
            long j = activityReference.get().noteDatabase.getNoteDao().insertNote(note);
            note.setNote_id(j);
            Log.e("ID","doInBackground: " + j);
            return true;

            return true;
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().setResult(note,1);
                activityReference.get().finish();
            }
        }
    }

}