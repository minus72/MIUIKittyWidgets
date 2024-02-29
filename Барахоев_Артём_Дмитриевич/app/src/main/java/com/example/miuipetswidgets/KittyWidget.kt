package com.example.miuipetswidgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.widget.RemoteViews

class KittyWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    companion object {
        private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
            val views = RemoteViews(context.packageName, R.layout.kitty_widget)

            // Устанавливаем картинку по умолчанию
            views.setImageViewResource(R.id.widgetImageView, R.drawable.kitty_idle_removebg)

            // Создаем интент для запуска анимации по нажатию
            val intent = Intent(context, KittyWidgetClickReceiver::class.java)
            intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, intArrayOf(appWidgetId))
            val pendingIntent = PendingIntent.getBroadcast(context, appWidgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            views.setOnClickPendingIntent(R.id.widgetImageView, pendingIntent)

            // Обновляем виджет
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
