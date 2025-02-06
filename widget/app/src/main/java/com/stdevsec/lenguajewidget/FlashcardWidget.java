package com.stdevsec.lenguajewidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class FlashcardWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Iterar sobre cada widget en caso de que haya varios
        for (int appWidgetId : appWidgetIds) {
            // Crear una vista remota para el widget
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_flashcard);

            // Llamar al servicio Retrofit para obtener la tarjeta aleatoria
            RetrofitClient.FlashcardService service = RetrofitClient.getInstance().create(RetrofitClient.FlashcardService.class);
            service.getRandomCard().enqueue(new Callback<CardDTO>() {
                @Override
                public void onResponse(Call<CardDTO> call, Response<CardDTO> response) {
                    // Si la respuesta es exitosa y contiene un cuerpo, actualizamos el widget
                    if (response.isSuccessful() && response.body() != null) {
                        CardDTO card = response.body();
                        // Actualizar el texto en el widget con la información de la tarjeta
                        views.setTextViewText(R.id.text_word, card.getPalabra());
                        views.setTextViewText(R.id.text_pronunciation, card.getPronunciacion());
                        views.setTextViewText(R.id.text_translation, card.getTraduccion());
                    }
                    // Actualizar el widget con los cambios
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }

                @Override
                public void onFailure(Call<CardDTO> call, Throwable t) {
                    // En caso de error, mostramos un mensaje de error
                    views.setTextViewText(R.id.text_word, "Error");
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }
            });
        }
    }
}
