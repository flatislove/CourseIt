// Creating angular JWTDemoApp with module name "JWTDemoApp"
angular.module('JWTDemoApp', [ 'ui.router' ])
// следующий метод будет запущен во время инициализации модуля. Что
// означает, что он будет работать только один раз.
.run(function(AuthService, $rootScope, $state) {
// Для реализации аутентификации с помощью ui-router нам нужно прослушать
// изменение состояния. Для каждого изменения состояния модуль ui-router будет транслировать
// '$ stateChangeStart'.
	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
		// проверка входа пользователя или нет
		if (!AuthService.user) {
		// Чтобы избежать бесконечного цикла изменения состояния, мы должны добавить
		// если условие.
			if (toState.name != 'login' && toState.name != 'register' && toState.name != 'news') {
				event.preventDefault();
                $state.go('login');
			}
		} else {
            // проверка права пользователя на просмотр состояний
			if (toState.data && toState.data.role) {
				var hasAccess = false;
				for (var i = 0; i < AuthService.user.roles.length; i++) {
					var role = AuthService.user.roles[i];
					if (toState.data.role == role) {
						hasAccess = true;
						break;
					}
				}
				if (!hasAccess) {
					event.preventDefault();
					$state.go('access-denied');
				}

			}
		}
	});
});