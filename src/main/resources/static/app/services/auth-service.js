angular.module('JWTDemoApp')
// Создание службы для хранения зарегистрированных данных пользователя
.service('AuthService', function() {
	return {
		user : null
	}
});
