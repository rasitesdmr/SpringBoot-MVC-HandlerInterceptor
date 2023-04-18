# 🎯 INTERCEPTOR NEDİR ?

<p align ="center">
<img src = "https://github.com/rasitesdmr/SpringBoot-MVC-HandlerInterceptor/blob/master/images/img1.png">
</p>

* Spring MVC Interceptor, Spring MVC framework içinde HTTP isteklerinin işlenmesi sırasında özelleştirilmiş ön ve son
  işlemleri gerçekleştiren bir bileşendir.

* işlenmesi sırasında ortak işlevleri merkezi bir şekilde yönetmek için kullanılır.

* Örneğin, günlükleme, kimlik doğrulama, yetkilendirme veya performans izleme gibi işlemler gerçekleştirilebilir.

* HandlerInterceptor, Spring MVC'deki Interceptor'lar için temel bir arabirimdir ve üç temel metodu vardır:

| Method              | Explanation                                                                                                                                                                                                                                                                     |
|---------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `preHandle()`       | İstek işlenmeden önce çağrılır ve istek üzerinde özelleştirilmiş işlemler yapmanıza olanak tanır. Bu metot, boolean değeri döndürür. Eğer true döndürülürse, isteğin işlemesine devam edilir. Eğer false döndürülürse, isteğin işlenmesi durur ve istemciye yanıt döndürülmez.  |
| `postHandle()`      | İstek işlendikten sonra ve gösterimi oluşturulmadan önce çağrılır. Bu metot, işlem sonucunu değiştirmeden ek işlemler yapmanızı sağlar. Örneğin, modele veri ekleyebilir veya model üzerinde düzenlemeler yapabilirsiniz.                                                       |
| `afterCompletion()` | Tüm işlemler tamamlandıktan ve istemciye yanıt döndürüldükten sonra çağrılır. Bu metot, kaynakları serbest bırakmak veya ortak temizleme işlemlerini gerçekleştirmek için kullanılabilir.                                                                                       |

## 📌 Gelin AOP Metotlarını Hatırlayalım.

| Terms            | Explanation                                                                                                                                                                                                                                                                                                                                                 |
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Before`         | Bu advice türü, hedef metot çağrılmadan önce çalışır. Bu, hedef metot çalıştırılmadan önce gerçekleştirilmesi gereken ön işlemleri uygulamak için kullanılır. Örneğin, giriş kontrolleri veya günlükleme gibi işlemler bu advice türüyle yapılabilir.                                                                                                       |
| `After`          | Bu advice türü, hedef metot çalıştırıldıktan sonra çalışır, ancak hedef metot çalıştıktan sonra oluşan sonuç veya istisna durumunu dikkate almaz. Genellikle temizleme veya kaynakları serbest bırakma gibi işlemler için kullanılır.                                                                                                                       |
| `Around`         | Bu advice türü, hem hedef metot çalıştırılmadan önce hem de çalıştırıldıktan sonra çalışır. Bu, hedef metot çağrısı üzerinde tam kontrol sağlar ve hedef metot çağrısı için öncesi, sonrası ve istisna durumlarında işlemler yapmanıza olanak tanır. Örneğin, performans ölçümü veya işlemli yönetimi gibi işlemler bu advice türüyle gerçekleştirilebilir. |
| `AfterReturning` | Bu advice türü, hedef metot başarıyla tamamlandıktan ve bir sonuç döndürdükten sonra çalışır. Bu, başarılı metot çağrısı sonrasında yapılandırılmış son işlemleri gerçekleştirmek için kullanılır. Örneğin, dönen sonuç üzerinde işlemler yapma veya başarılı çağrıları günlüğe kaydetme gibi işlemler bu advice türüyle yapılabilir.                       |
| `AfterThrowing`  | Bu advice türü, hedef metot çalıştırılırken bir istisna meydana geldiğinde çalışır. Bu, istisna durumlarında özel işlemler yapmanıza olanak tanır. Örneğin, belirli istisna türlerini yakalayarak özel hata işleme veya günlükleme işlemleri gerçekleştirebilirsiniz.                                                                                       |

## 📌 Peki Sizce'de Interceptor'lar , AOP Mantığına Benzemiyor Mu ?

* Spring MVC Interceptor'lar ve AOP (Aspect Oriented Programming) arasında bazı benzerlikler bulunmaktadır.

* Her ikisi de uygulamanın belirli noktalarında ek işlemler gerçekleştirmek için kullanılır ve bu sayede kodun
  modülerliğini ve yeniden kullanılabilirliğini artırır.

* Ancak, önemli farklar da vardır:

| Differences     | Explanation                                                                                                                                                                                                                                                                                                                                                |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Kapsam`        | Interceptor'lar yalnızca Spring MVC'deki HTTP isteklerinin işlenmesiyle ilgilidir ve istek-yanıt yaşam döngüsü boyunca çalışır. AOP ise daha genel bir yaklaşımdır ve uygulamanın herhangi bir katmanında veya bileşeninde çalışabilir. AOP, metot çağrıları, hata işleme ve daha fazlası gibi her türlü işlemle ilgili olabilir.                          |
| `Yöntem`        | Interceptor'lar, HandlerInterceptor arabirimini uygulayarak veya HandlerInterceptorAdapter sınıfını genişleterek oluşturulur. AOP ise, AspectJ gibi dillerle veya Spring AOP gibi çerçevelerle uygulanır. AOP, özel anotasyonlar ve "pointcut" ifadeleri kullanarak belirli işlemlerin gerçekleştirilmesi gereken noktaları tanımlar.                      |
| `İşlem Zamanı`  | Interceptor'lar, istek işlenmeden önce (preHandle), istek işlendikten sonra (postHandle) ve istemciye yanıt döndürüldükten sonra (afterCompletion) olmak üzere üç aşamada çalışır. AOP'de ise, "before", "after", "around", "afterReturning" ve "afterThrowing" gibi farklı özelliklere sahip "advice" türleri kullanarak daha esnek bir kontrol sağlanır. |
| `Uygulama`      | Interceptor'lar, Spring MVC uygulamasında belirli URI'lerle ilişkilendirilirken, AOP, uygulamanın herhangi bir bölümünde kullanılabilir ve istediğiniz herhangi bir noktada ek işlemler gerçekleştirmek için uygulanabilir.                                                                                                                                |

* Daha genel bakarsak :

| Interceptor                                                                                        |                                                                                                                                                                                                                                                                                                                                             
|----------------------------------------------------------------------------------------------------|
| Genellikle web uygulamalarında kullanılır ve HTTP istek-yanıt döngüsü üzerinde kontrol sağlar.     | 
| Spring MVC uygulamalarında, istek öncesi, sonrası ve tamamlanmasında eylemleri gerçekleştirebilir. | 
| Öncelikle Spring MVC tarafından sağlanan HandlerInterceptor arayüzü ile çalışır.                   | 

| AOP                                                                                     |                                                                                                                                                                                                                                                                                                                                             
|-----------------------------------------------------------------------------------------|
| Uygulamanın herhangi bir katmanında kullanılabilir ve daha genel amaçlıdır.             | 
| Bir metot çağrısı öncesi, sonrası, hata yakalama ve çevresinde eylemler gerçekleştirir. | 
| Spring AOP veya AspectJ gibi AOP çözümleri ile çalışır.                                 | 

* Interceptor ile yapılabilen bazı işlemler, AOP kullanarak da gerçekleştirilebilir.

* Örneğin, her ikisiyle de günlük kaydı, güvenlik kontrolleri, işlem yönetimi ve performans izleme gibi işlemler
  yapabilirsiniz.

* Fakat AOP daha genel amaçlıdır ve uygulamanın herhangi bir katmanında kullanılabilirken, Interceptor'lar genellikle
  web uygulamaları ve HTTP istek-yanıt döngüsü ile sınırlıdır.

## 📌 Interceptor İle Log'lama Yaparken MDC Denk Geldiniz Mi ?

* MDC (Mapped Diagnostic Context) özelliği, genellikle günlük (log) çerçevelerinde (ör. Log4j, Logback, SLF4J) bulunan
  ve uygulama boyunca geçen taleplerle ilgili ek bilgileri günlük mesajlarına eklemeye yarayan bir mekanizmadır.

* MDC, anahtar-değer çiftlerini kullanarak bu ek bilgileri saklar ve günlük mesajlarını yazarken kullanılabilir.

* Gelin örnek üzerinden bakalım :

 ```java

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        MDC.put("api", request.getRequestURI());
        MDC.put("method", request.getMethod());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
```

* Loglarımın içine api adında key oluşturuyorum ve value değerine isteğin url veriyorum.

* Bu ne işimize yarıyor derseniz loglarımıza incelerken daha kapsamlı bakmamızı sağlıyor.

## 📌 Şimdi Projemize Dönelim 

* [header-Interceptors ](./header-Interceptors)
* [response-time-Interceptors](./response-time-Interceptors)