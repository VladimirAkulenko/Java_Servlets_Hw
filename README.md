# Домашнее задание к занятию «2.1. Servlet Containers»

В качестве решения пришлите ссылки на ваши GitHub-проекты в личном кабинете студента на сайте [netology.ru](https://netology.ru).

**Важная информация**

1. Перед стартом работы изучите, пожалуйста, ссылки на главной странице [репозитория с домашними заданиями](../README.md).
2. Если у вас что-то не получилось, тогда оформляйте Issue [по установленным правилам](../report-requirements.md).

## Как сдавать задачи

1. Создайте на вашем компьютере Maven-проект.
1. Инициализируйте в нём пустой Git-репозиторий.
1. Добавьте в него готовый файл [.gitignore](../.gitignore).
1. Добавьте в этот же каталог остальные необходимые файлы.
1. Сделайте необходимые коммиты.
1. Создайте публичный репозиторий на GitHub и свяжите свой локальный репозиторий с удалённым.
1. Сделайте пуш: удостоверьтесь, что ваш код появился на GitHub.
1. Ссылку на ваш проект отправьте в личном кабинете на сайте [netology.ru](https://netology.ru).

## CRUD

### Легенда

В рамках лекции мы реализовали практически полноценный In-Memory CRUD-сервер (Create Read Update Delete) на базе сервлетов. Этому серверу не хватает двух вещей:

1. Привести код в должный вид: вынести методы в константы, убрать дублирующийся код.
1. Реализовать репозиторий — пока вместо репозитория установлена заглушка.

### Задача

1. Осуществите рефакторинг кода.
1. Реализуйте репозиторий с учётом того, что методы репозитория могут вызываться конкурентно, т. е. в разных потоках.

Как должен работать `save`:

1. Если от клиента приходит пост с id=0, значит, это создание нового поста. Вы сохраняете его в списке и присваиваете ему новый id. Достаточно хранить счётчик с целым числом и увеличивать на 1 при создании каждого нового поста.
1. Если от клиента приходит пост с id !=0, значит, это сохранение (обновление) существующего поста. Вы ищете его в списке по id и обновляете. Продумайте самостоятельно, что вы будете делать, если поста с таким id не оказалось: здесь могут быть разные стратегии.

### Результат

В качестве решения пришлите ссылку на ваш GitHub-репозиторий в личном кабинете студента на сайте [netology.ru](https://netology.ru).