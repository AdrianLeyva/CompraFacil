package persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hack03 on 27/05/16.
 */
public class InventarioSQLiteOpenHelper extends SQLiteOpenHelper {


    public InventarioSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("creat table Inventario(Nombre string, Categoría string, Precio float, Cantidad int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Inventario");
        db.execSQL("creat table Inventario(Nombre string, Categoría string, Precio float, Cantidad int)");

    }
}
