package com.pesiik.samsmu.suicidetest.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Arrays;
import java.util.List;

public class QuestionLab {
    private static QuestionLab sQuestionLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private List<Question> mQuestions;

    public static QuestionLab get(Context context){
        if(sQuestionLab == null){
            sQuestionLab = new QuestionLab(context);
        }
        return sQuestionLab;
    }

    private QuestionLab(Context context){
        mContext = context;
        mQuestions = testData();
    }

    public Question getQuestion(int position){
        return mQuestions.get(position);
    }

    private List<Question> testData(){
        List<Question> questions = Arrays.asList(
                new Question("Испытывает неловкость, когда вступает с кем-нибудь в разговор.", true, Question.Type.none),
                new Question("Нет желания раскрываться перед другими.", true, Question.Type.none),
                new Question("Во всем любит состязание, соревнование, борьбу.", true, Question.Type.none),
                new Question("Предъявляет к себе высокие требования.", true, Question.Type.adaptability),
                new Question("Часто ругает себя за сделанное.", true, Question.Type.adaptability),
                new Question("Часто чувствует себя униженным.", true, Question.Type.none),
                new Question("Сомневается, что может нравиться кому-нибудь из лиц противоположного пола.", true, Question.Type.none),
                new Question("Свои обещания выполняет всегда.", true, Question.Type.none),
                new Question("Теплые, добрые отношения с окружающими.", true, Question.Type.none),
                new Question("Человек сдержанный, замкнутый; держится от всех чуть в стороне.", true, Question.Type.none),
                new Question("В своих неудачах винит себя.", true, Question.Type.adaptability),
                new Question("Человек ответственный, на него можно положиться.", true, Question.Type.adaptability),
                new Question("Чувствует, что не в силах хоть что-нибудь изменить, все усилия напрасны.", true, Question.Type.none),
                new Question("На многое смотрит глазами сверстников.", true, Question.Type.none),
                new Question("Принимает в целом те правила и требования, которым надлежит следовать.", true, Question.Type.adaptability),
                new Question("Собственных убеждений и правил не хватает.", true, Question.Type.none),
                new Question("Любит мечтать – иногда прямо среди бела дня. С трудом возвращается от мечты к действительности.", true, Question.Type.escapism),
                new Question("Всегда готов к защите и даже нападению: «застревает» на переживаниях обид, мысленно перебирая способы мщения.", true, Question.Type.escapism),
                new Question("Умеет управлять собой и собственными поступками, заставлять себя, разрешать себе; самоконтроль для него не проблема.", true, Question.Type.adaptability),
                new Question("Часто портится настроение: накатывает уныние, хандра.", true, Question.Type.none),
                new Question("Все, что касается других, не волнует: сосредоточен на себе; занят собой.", true, Question.Type.none),
                new Question("Люди, как правило, ему нравятся.", true, Question.Type.adaptability),
                new Question("Не стесняется своих чувств, открыто их выражает.", true, Question.Type.adaptability),
                new Question("Среди большого стечения народа бывает немножко одиноко.", true, Question.Type.none),
                new Question("Сейчас очень не по себе. Хочется все бросить, куда-нибудь спрятаться.", true, Question.Type.none),
                new Question("С окружающими обычно ладит.", true, Question.Type.adaptability),
                new Question("Всего труднее бороться с самим собой.", true, Question.Type.adaptability),
                new Question("Настораживает незаслуженное доброжелательное отношения окружающих.", true, Question.Type.none),
                new Question("В душе – оптимист, верит в лучшее.", true, Question.Type.adaptability),
                new Question("Человек неподатливый, упрямый; таких называют трудными.", true, Question.Type.none),
                new Question("К людям критичен и судит их, если считает, что они этого заслуживают.", true, Question.Type.none),
                new Question("Обычно чувствует себя не ведущим, а ведомым: ему не всегда удается мыслить и действовать самостоятельно. ", true, Question.Type.none),
                new Question("Большинство из тех, кто его знает, хорошо к нему относятся, любят его.", true, Question.Type.adaptability),
                new Question("Иногда бывают такие мысли, которыми не хотелось бы ни с кем делиться.", true, Question.Type.none),
                new Question("Человек с привлекательной внешностью.", true, Question.Type.adaptability),
                new Question("Чувствует себя беспомощным, нуждается в том, чтобы кто-то был рядом.", true, Question.Type.none),
                new Question("Приняв решение, следует ему.", true, Question.Type.adaptability),
                new Question("Принимая, казалось бы, самостоятельные решения, не может освободиться от влияния других людей.", true, Question.Type.none),
                new Question("Испытывает чувство вины, даже если винить себя как будто не в чем.", true, Question.Type.none),
                new Question("Чувствует неприязнь к тому, что его окружает.", true, Question.Type.none),
                new Question("Всем доволен.", true, Question.Type.adaptability),
                new Question("Выбит из колеи: не может собраться, взять себя в руки, организовать себя.", true, Question.Type.none),
                new Question("Чувствует вялость: все, что раньше волновало, стало вдруг безразличным.", true, Question.Type.none),
                new Question("Уравновешен, спокоен.", true, Question.Type.adaptability),
                new Question("Разозлившись, нередко выходит из себя.", true, Question.Type.none),
                new Question("Часто чувствует себя обиженным.", true, Question.Type.none),
                new Question("Человек порывистый, нетерпеливый, горячий, не хватает сдержанности.", true, Question.Type.adaptability),
                new Question("Бывает, что сплетничает.", true, Question.Type.none),
                new Question("Не очень доверяет своим чувствам: они иногда подводят его.", true, Question.Type.none),
                new Question("Довольно трудно быть самим собой.", true, Question.Type.none),
                new Question("На первом месте рассудок, а не чувство: прежде чем что-либо сделать, подумает.", true, Question.Type.adaptability),
                new Question("Происходящее с ним толкует на свой лад. Способен напридумывать лишнего, словом, не от мира сего.", true, Question.Type.none),
                new Question("Человек, терпимый к людям, принимает каждого таким, каков он есть.", true, Question.Type.adaptability),
                new Question("Старается не думать о своих проблемах.", true, Question.Type.escapism),
                new Question("Считает себя интересным человеком - привлекательным как личность, заметным.", true, Question.Type.adaptability),
                new Question("Человек стеснительный. Легко тушуется.", true, Question.Type.none),
                new Question("Обязательно нужно напоминать, подталкивать, чтобы довел дело до конца.", true, Question.Type.none),
                new Question("В душе чувствует превосходство над другими.", true, Question.Type.none),
                new Question("Нет ничего, в чем бы он выразил себя, проявил свою индивидуальность, свое «Я».", true, Question.Type.none),
                new Question("Боится того, что подумают о нем другие.", true, Question.Type.none),
                new Question("Честолюбив, неравнодушен к успеху, похвале: в том, что для него существенно, старается быть среди лучших.", true, Question.Type.adaptability),
                new Question("Человек, в котором в настоящий момент многое достойно презрения.", true, Question.Type.none),
                new Question("Человек деятельностный, энергичный, полон инициатив.", true, Question.Type.adaptability),
                new Question("Пасует перед трудностями и ситуациями, которые грозят осложнениями.", true, Question.Type.escapism),
                new Question("Себя просто недостаточно ценит.", true, Question.Type.none),
                new Question("По натуре вожак и умеет влиять на других.", true, Question.Type.none),
                new Question("Относится к себе в целом хорошо.", true, Question.Type.adaptability),
                new Question("Человек настойчивый, напористый, ему всегда важно настоять на своем.", true, Question.Type.adaptability),
                new Question("Не любит, когда с кем-нибудь портятся отношения, особенно если разногласия грозят стать явными.", true, Question.Type.none),
                new Question("Подолгу не может принять решение, а потом сомневается в его правильности.", true, Question.Type.none),
                new Question("Пребывает в рассеянности, все спуталось, все смешалось у него.", true, Question.Type.none),
                new Question("Доволен собой.", true, Question.Type.adaptability),
                new Question("Невезучий.", true, Question.Type.none),
                new Question("Человек приятный, располагающий к себе.", true, Question.Type.adaptability),
                new Question("Лицом, может, и не очень пригож, но может нравиться как человек, как личность.", true, Question.Type.adaptability),
                new Question("Презирает лиц противоположного пола и не связывается с ними.", true, Question.Type.none),
                new Question("Когда нужно что-то сделать, охватывает страх: а вдруг не справлюсь, а вдруг не получится?", true, Question.Type.none),
                new Question("Легко, спокойно на душе, нет ничего, что сильно бы тревожило.", true, Question.Type.adaptability),
                new Question("Умеет упорно работать.", true, Question.Type.adaptability),
                new Question("Чувствует, что растет, взрослеет: меняется сам и его отношение к окружающему миру.", true, Question.Type.adaptability),
                new Question("Случается, что говорит о том, в чем совсем не разбирается.", true, Question.Type.none),
                new Question("Всегда говорит только правду.", true, Question.Type.none),
                new Question("Встревожен, обеспокоен, напряжен.", true, Question.Type.none),
                new Question("Чтобы заставить хоть что-то сделать, нужно как следует настоять, и тогда он уступит.", true, Question.Type.none),
                new Question("Чувствует неуверенность в себе.", true, Question.Type.none),
                new Question("Обстоятельства часто вынуждают защищать себя, оправдываться и обосновывать свои поступки.", true, Question.Type.escapism),
                new Question("Человек уступчивый, податливый, мягкий в отношениях с другими.", true, Question.Type.none),
                new Question("Человек толковый, любит размышлять.", true, Question.Type.adaptability),
                new Question("Иной раз любит прихвастнуть.", true, Question.Type.none),
                new Question("Принимает решения и тут же их меняет: презирает себя за безволие, а сделать с собой ничего не может.", true, Question.Type.none),
                new Question("Старается полагаться на свои силы, не рассчитывает на чью-то помощь.", true, Question.Type.adaptability),
                new Question("Никогда не опаздывает.", true, Question.Type.none),
                new Question("Испытывает ощущение скованности, внутренней несвободы.", true, Question.Type.none),
                new Question("Выделяется среди других.", true, Question.Type.adaptability),
                new Question("Не очень надежный товарищ, не во всем можно положиться.", true, Question.Type.none),
                new Question("В себе все ясно, себя хорошо понимает.", true, Question.Type.adaptability),
                new Question("Общительный, открытый человек, легко сходится с людьми.", true, Question.Type.adaptability),
                new Question("Силы и способности вполне соответствуют тем задачам, которые приходится решать; со всем может справиться.", true, Question.Type.adaptability),
                new Question("Себя не ценит, никто всерьез его не воспринимает; в лучшем случае к нему снисходительны, просто терпят.", true, Question.Type.none),
                new Question("Беспокоится, что лица противоположного пола слишком занимают его мысли.", true, Question.Type.none),
                new Question("Все свои привычки считает хорошими.", true, Question.Type.none),
                new Question("Снижение интереса и удовольствия к привычным для Вас событиям и действиям", false, Question.Type.depression),
                new Question("Чувство опустошённости, безнадёжности, ухудшения настроения", false, Question.Type.depression),
                new Question("Проблемы со сном: бессонница или, наоборот, Вы слишком много спали", false, Question.Type.depression),
                new Question("Вы чувствовали усталость или испытывали недостаток энергии", false, Question.Type.depression),
                new Question("Снижение или повышение аппетита", false, Question.Type.depression),
                new Question("Вы испытывали чувство неудовлетворённости собой – или думали о том, что Вы неудачник, или что подводите себя или свою семью", false, Question.Type.depression),
                new Question("Трудности с концентрацией внимания, например, когда читаете или смотрите телевизор", false, Question.Type.depression),
                new Question("Вы делаете все или говорите так медленно, что другие люди начинают это замечать или наоборот – Вам не силится на месте или Вы так неутомимы, что делаете гораздо больше, чем обычно", false, Question.Type.depression),
                new Question("Вам приходят мысли, что лучше всего было бы умереть или Вы пытались поранить себя каким-либо образом", false, Question.Type.depression));

        return questions;
    }

    public boolean hasAllAnswer(){
        boolean allAnswer = true;

        for(Question question : mQuestions){
            if(!question.isHasAnswer()){
                allAnswer = false;
                break;
            }
        }
        return allAnswer;
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }
}
