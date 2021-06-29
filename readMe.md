# cs-ui-acceptance-test

- maven,
- junit,
- pom pattern...

#### ACCEPTANCE CASES:
|    -------  | -------------------------------------------------------------------------------------------------------- |
| ------ | ------ |
| CASE 1 | Valid email & password ile giriş yapılır, Login olan kullanıcı için kontroller yapılır.
| CASE 2 | Invalid email & password ile giriş yapılmak istenir, hata mesajları kontrol edilir.
| CASE 3 | Empty emial & password ile giriş yapılmak istenir, hata mesajları kontrol edilir.
| CASE 4 | *Password alanındaki değerlerin görülebilir olduğunun kontrolü yapılır. (göz ikonu)
| CASE 5 | Kayıtlı valid email ile forgot password alanına giriş yapılır ve  kontrol edilir.
| CASE 6 | Kayıtlı olmayan valid email ile forgot password alanına giriş yapılır ve  hata mesajı kontrol edilir.
| CASE 7 | Facebook entegrasyonu seçilerek login olma isteği gerçekleştirilir.
| CASE 8 | Sign up butonu için redirect kontrolü yapılır.
| CASE 9 | Login olan bir kullancıyla yeniden login sayfası ziyaret edildiğinde redirect kontrolü yapılır.


####  NOTES:

|    -------  | ------------------------------------------------------------------------------------------------------- |
| ------ | ------ |
| NOTE 1 | Diller değiştirilerek login olma case'leri denenebilir.
| NOTE 2 | Çözünürlük değiştirilerek login olma case'leri denenebilir.
| NOTE 3 | CSS kaymalarını anlayabilmek için layout testleri de eklenebilir.