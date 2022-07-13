package com.example.poeoptimaltrade.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.poeoptimaltrade.database.dao.*
import com.example.poeoptimaltrade.database.entity.*

@Database(entities = [Category::class, Currency::class, Fragment::class, DivinationCard::class,
    Scarab::class, Vial::class, Fossil::class, DeliriumOrb::class, Oil::class, Sentinel::class,
    Artifact::class, Resonator::class, Beast::class],
    autoMigrations = [AutoMigration(from = 1, to = 2, spec = PoeTradeDatabase.PoeTradeAutoMigration::class),
        AutoMigration(from = 3, to = 4), AutoMigration(from = 4, to = 5), AutoMigration(from = 5, to = 6)],
        version = 6, exportSchema = true)

abstract class PoeTradeDatabase : RoomDatabase() {
    abstract val divinationCardDao: DivinationCardDao
    abstract val deliriumOrbDao: DeliriumOrbDao
    abstract val resonatorDao: ResonatorDao
    abstract val categoryDao: CategoryDao
    abstract val currencyDao: CurrencyDao
    abstract val fragmentDao: FragmentDao
    abstract val sentinelDao: SentinelDao
    abstract val artifactDao: ArtifactDao
    abstract val scarabDao: ScarabDao
    abstract val fossilDao: FossilDao
    abstract val beastDao: BeastDao
    abstract val vialDao: VialDao
    abstract val oilDao: OilDao

    companion object {
        @Volatile
        private var INSTANCE: PoeTradeDatabase? = null

        val MIGRATION_2_3 = object : Migration(2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE currency_table ADD COLUMN currency_league_price FLOAT")
                database.execSQL("ALTER TABLE currency_table ADD COLUMN currency_standard_price FLOAT")
            }
        }

        fun getInstance(context: Context): PoeTradeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PoeTradeDatabase::class.java,
                        "poe_trade_database")
                        .addMigrations(MIGRATION_2_3)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    @DeleteColumn(tableName = "currency_table", columnName = "currency_league_price")
    @DeleteColumn(tableName = "currency_table", columnName = "currency_standard_price")
    class PoeTradeAutoMigration: AutoMigrationSpec {}
}

