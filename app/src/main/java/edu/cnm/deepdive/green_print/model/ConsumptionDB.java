package edu.cnm.deepdive.green_print.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;
//import edu.cnm.deepdive.green_print.model.ConsumptionDB.Converters;
import edu.cnm.deepdive.green_print.model.dao.ActivityDao;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionApplication;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.Calendar;

@Database(
    entities = {Activity.class, Consumption.class},
    version = 1,
    exportSchema = true
)


//@TypeConverters(Converters.class)
public abstract class ConsumptionDB extends RoomDatabase {

    private static final String DB_NAME = "apod_db";

    /**
     * Returns the single instance of {@link ConsumptionDao} for the current application context.
     *
     * @return single {@link ConsumptionDao} instance reference.
     */
    public synchronized static ConsumptionDB getInstance() {
      return InstanceHolder.INSTANCE;
    }

    /**
     * Returns an instance of a Room-generated implementation of {@link ConsumptionDao}.
     *
     * @return data access object for CRUD operations involving {@link Activity} instances.
     */
    public abstract ConsumptionDao getConsumtionDao();

    public abstract ActivityDao getActivityDao();

    private static class InstanceHolder {

      private static final ConsumptionDB INSTANCE = Room.databaseBuilder(
          ConsumptionApplication.getInstance().getApplicationContext(), ConsumptionDB.class, DB_NAME)
          .build();

    }

      /**
       * Supports conversion operations for persistence of relevant types not natively supported by
       * Room/SQLite.
       */
//      public static class Converters {
//
//        /**
//         * Converts a {@link Long} value containing the number of milliseconds since the start of the
//         * Unix epoch (1970-01-01 00:00:00.000 UTC) to an instance of {@link Calendar}, and returns
//         * the latter.
//         *
//         * @param milliseconds date-time as a number of milliseconds since the start of the Unix
//         * epoch.
//         * @return date-time as a {@link Calendar} instance.
//         */
//        @Nullable
//        @TypeConverter
//        public static Calendar calendarFromLong(@Nullable Long milliseconds) {
//          if (milliseconds != null) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTimeInMillis(milliseconds);
//            return calendar;
//          }
//          return null;
//        }
//
//      /**
//       * Converts a {@link Calendar} date-time value number of milliseconds since the start of the
//       * Unix epoch (1970-01-01 00:00:00.000 UTC), and returns the latter.
//       *
//       * @param calendar date-time as a {@link Calendar} instance.
//       * @return date-time as a number of milliseconds since the start of the Unix epoch.
//       */
//      @Nullable
//      @TypeConverter
//      public static Long longFromCalendar(@Nullable Calendar calendar) {
//        return (calendar != null) ? calendar.getTimeInMillis() : null;
//      }
//
//      /**
//       * Converts an {@link Integer} value containing the days since the start of the Unix epoch
//       * (1970-01-01) to an instance of {@link Date}, and returns the latter. Both of these are
//       * interpreted as local dates, with no reference to time zone.
//       *
//       * @param days local date as a number of days since the start of the Unix epoch.
//       * @return local date as a {@link Date} instance.
//       */
//      @Nullable
//      @TypeConverter
//      public static Date dateFromInt(@Nullable Integer days) {
//        return (days != null) ? Date.fromEpochDays(days) : null;
//      }
//
//      /**
//       * Converts a {@link Date} local date value to a number of days since the start of the Unix
//       * epoch (1970-01-01), and returns the latter. Both of these are interpreted as local dates,
//       * with no reference to time zone.
//       *
//       * @param date local date as a {@link Date} instance.
//       * @return local date as a number of days since the start of the Unix epoch.
//       */
//      @Nullable
//      @TypeConverter
//      public static Integer intFromDate(@Nullable Date date) {
//        return (date != null) ? date.toEpochDays() : null;
//      }
//
//      }
//   }
}
