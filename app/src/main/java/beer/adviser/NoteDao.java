package beer.adviser;

import android.provider.SyncStateContract;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Insert
    void insert(Note note);

    @Update
    void update(Note repos);

    @Delete
    void delete(Note note);

    @Delete
    void delete(Note... note);

    @Query("SELECT * FROM note")
    void deleteAll(Note note);

}
