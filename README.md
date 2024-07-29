## اعضای گروه: سپهر حرفی - زهرا علیپور - محمدمهدی واحدی 
## مقدمه

در ابتدا Kanban board را به عنوان پروژه میسازیم و تسک‌های مربوط به آزمایش را مشخص می‌کنیم تا اعضای گروه تسک‌ها را به عهده بگیرند و assign شوند:

<img width="1512" alt="Screenshot 2024-07-26 at 4 22 04 PM" src="https://github.com/user-attachments/assets/bf447870-9a22-4b0e-b6b0-daffc6d6760b">

## بخش اول
طبق صورت آزمایش در ابتدا پروژه‌ی json-simple را دانلود می‌کنیم تا تست آن را ران بکنیم. طبق چیزی که گفته شد در فایل pom.xml عدد configuration را برابر ۱۷ قرار می‌دهیم تا بتوانیم پروژه را ران کنیم.

<img width="553" alt="Screenshot 2024-07-28 at 7 40 16 PM" src="https://github.com/user-attachments/assets/8924871f-554f-499c-993f-8c280522c327">

حال کلاس TestJson را ران می‌کنیم: 

<img width="1446" alt="Screenshot 2024-07-26 at 10 23 42 PM" src="https://github.com/user-attachments/assets/7758de87-d829-440a-9656-d15d94a56744">
<img width="1512" alt="Screenshot 2024-07-26 at 10 28 12 PM" src="https://github.com/user-attachments/assets/12feb357-7640-429c-8ca5-58155ac7a945">

در مرحله بعدی نتایج را به صورت یک گزارش html اکسپورت می‌کنیم:

<img width="624" alt="Screenshot 2024-07-26 at 10 36 16 PM" src="https://github.com/user-attachments/assets/b641ba93-dac4-49c5-9aa6-22a479e014c0">
<img width="608" alt="Screenshot 2024-07-26 at 10 37 02 PM" src="https://github.com/user-attachments/assets/421ce56c-08de-4425-8d6c-ecae50df8221">

همان طور که در دستور آزمایش نیز مشخص شده می‌توانیم گزارش و همچنین خطوط پوشش داده شده را با رنگ سبز و پوشش داده نشده را با رنگ قرمز مشاهده کنیم:

<img width="1512" alt="Screenshot 2024-07-26 at 10 38 27 PM" src="https://github.com/user-attachments/assets/9f1bba37-c327-439c-afba-ab72912bfdf1">
<img width="1139" alt="Screenshot 2024-07-26 at 10 39 11 PM" src="https://github.com/user-attachments/assets/dfc593c1-01dc-4373-83e1-17bac6470a64">

## بخش دوم
### زیربخش اول
با بررسی ها ابتدا متوجه می‌شویم که دو مشکل در کلاس library وجود دارد. مشکل اول در تابع lendbook است که چک نمیکند که دانشجو در کتابخانه ثبت نام شده باشد.

![1](https://github.com/user-attachments/assets/e52af91f-f6c6-4ae4-93aa-cdb86339edda)


بعد از آن یک تست برای این تابع مینویسیم که پاس نشود.

![2](https://github.com/user-attachments/assets/989c09bd-a4ac-4f78-bf28-19942ebae99a)
![3](https://github.com/user-attachments/assets/9b5a09c3-0812-4487-9a89-dd6265a37dfd)

حالا تابع را تغییر میدهیم تا تست پاس شود.

![4](https://github.com/user-attachments/assets/4b775c0d-37c9-4935-bd32-a116aed37c83)
![5](https://github.com/user-attachments/assets/1f9da637-1dfc-48d5-973b-b9a033b9039c)

ایراد دوم هم در تابع retrunBook است که پس از تحویل کتاب،‌کتاب را از کتاب های دانشجو حذف نمیکند.

![6](https://github.com/user-attachments/assets/9964ded8-6675-4af3-8987-c43d699feae8)

برای آن هم یک تست مینویسیم که پاس نشود.

![7](https://github.com/user-attachments/assets/fc50963c-0603-42bf-b5a1-df1a2e2b3c48)
![8](https://github.com/user-attachments/assets/7a061079-f5ff-410b-9fea-eb63bbc7986d)

حالا کد را تغییر میدهیم تا تست پاس شود.

![9](https://github.com/user-attachments/assets/f49cf937-fd89-4b1f-ba12-60805ccc0f08)
![10](https://github.com/user-attachments/assets/f39a43e2-9346-4746-ab59-3cfefaadf12d)


### زیربخش دوم
در ابتدا تعدادی تست برای چک کردن نیازهای توابع مشخص شده می‌نویسم. در این تست‌ها هم چک می‌کنیم که اگر تایپ مناسب نبود null برگردانده شود (که با توجه به تابع اولیه این تست‌ برای دو تابع پاس خواهد شد) و همچنین تست‌هایی برای چک کردن عملکرد برگرداندن بر اساس کلید‌های مشخص شده می‌نویسیم:
<img width="791" alt="Screenshot 2024-07-29 at 8 48 11 AM" src="https://github.com/user-attachments/assets/d98bb393-e33d-4b9e-90a5-6de53cb562e3">

<img width="927" alt="Screenshot 2024-07-29 at 8 49 40 AM" src="https://github.com/user-attachments/assets/65ca6bd3-4b6b-48d4-aa07-70bcd3c0c53d">

<img width="984" alt="Screenshot 2024-07-29 at 8 49 57 AM" src="https://github.com/user-attachments/assets/2c80728d-55e2-49a8-bb2e-1011a2deb2f1">

<img width="967" alt="Screenshot 2024-07-29 at 8 50 04 AM" src="https://github.com/user-attachments/assets/bb553c20-ae7c-46b1-8bcf-6112080d7c41">


حال فایل تست را ران خواهیم کرد تا عملکرد را مشاهده کنیم و همان طور که انتظار میرفت تنها تست‌های مربوط به چک کردن null در صورت تایپ نامعتبر پاس می‌شوند:

<img width="276" alt="Screenshot 2024-07-29 at 8 51 12 AM" src="https://github.com/user-attachments/assets/9286e0dd-dfc7-4d38-bfd2-f58a9513d913">

حالا با توجه به نیازمندی تست‌ها توابعمان را تکمیل می‌کنیم:
<img width="1013" alt="Screenshot 2024-07-29 at 9 00 52 AM" src="https://github.com/user-attachments/assets/8272d5b2-9852-43e4-8323-daeaf21ea35e">
<img width="939" alt="Screenshot 2024-07-29 at 9 01 31 AM" src="https://github.com/user-attachments/assets/71a857a3-47b4-46d9-92e4-8154550f817d">

حالا که توابع ما تکمیل شدند تست‌ها را دوباره ران می‌کنیم و میبینیم که به درستی پاس می‌شوند:

<img width="280" alt="Screenshot 2024-07-29 at 8 54 09 AM" src="https://github.com/user-attachments/assets/0961ad60-5818-4425-a10b-350624b21ece">




## پرسش‌ها
### پرسش اول
### پرسش دوم
### پرسش سوم
### پرسش چهارم
