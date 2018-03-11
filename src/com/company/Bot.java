package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;

public class Bot {

    Random random = new Random();

    String[] COMMON_PHRASES = {  //Общие фразы
            "Хорошо болтаем :)",
            "Ану белорэ дела'на!.. Прости, о Блад Эльфах задумался... О чем ты говорил?",
            "Это понимаем только мы - фанаты WOW, не так ли?",
            "Ты хороший собеседник. Может, расскажешь мне о своей любимой расе?",
            "Ордынец тебя поймет :)",
            "Ордынец тебя во всем поддержит, бро ;)",
            "Некоторые твои речевые обороты сводят меня с ума :D",
            "Понимаешь, жизнь такая штука..."
    };
    String[] ELUSIVE_ANSWERS = {  //Уклончивые ответы
            "Ах, если бы я только знал.",
            "Мне кажется, ты и сам уже догадался, не так ли?",
            "Так. Тут нужно подумать. Где мой Вневременной остров?",
            "Тебе и правда это интересно?",
            "Давай сохраним интригу? ;)",
            "Ох, была бы у меня такая оооогрооомнаааая энциклопедия..."
    };
    HashMap<String, String> QUESTIONS_PATTERNS = new HashMap<String, String>(){
        {
            //hello
            put("привет", "hello");
            put("хай", "hello");
            put("хелло", "hello");
            put("здрасте", "hello");
            put("здравствуй", "hello");
            put("добрый день", "hello");
            put("добрый вечер", "hello");
            put("доброе утро", "hello");
            put("доброго времени суток", "hello");
            put("день добрый", "hello");
            put("утро доброе", "hello");
            put("вечер добрый", "hello");
        }
    };
    HashMap<String, String> ANSWERS_PATTERNS = new HashMap<String, String>(){
        {
            put("hello", "Привет!");
        }
    };

    public Bot(){
        //Random random = new Random();
    }

    public String botTalk(String ourMessage){
        ourMessage = String.join(" ", ourMessage.toLowerCase().split("[,.?!{}/|:;]%"));
        String hisTalking;

        if (ourMessage.trim().endsWith("?")){  //trim() - удаляет пробелы в начале и конце строки
            hisTalking = ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)];  //рандомный ответ из всего массива
        } else {
            hisTalking = COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        }
        return hisTalking;
    }

    //String.join - объединяет строку, разделяя слова первым элементом
    //split() - разбивает String на массив строк с разделением указанной подстрокой





}
