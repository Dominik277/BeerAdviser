package beer.adviser.util;

import java.util.Date;

import androidx.room.TypeConverter;

public class DateRoomConverter {

    @TypeConverter
    public static Date toDate(Long value){
        return value == null ? null : new Date(value);
    }

    public static Long toLong(Date value){
        return value == null ? null : value.getTime();
    }

}
