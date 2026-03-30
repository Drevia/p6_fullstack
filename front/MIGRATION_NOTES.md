# Migration vers Angular 20 avec Jest

## ✅ Changements effectués

### 1. **Mise à jour des dépendances**
- Angular : v14 → v20
- TypeScript : v4.7 → v5.5
- Framework de test : Karma/Jasmine → Jest

### 2. **Conversion en composants standalone**
- `AppComponent` : Conversion en composant standalone
- `HomeComponent` : Conversion en composant standalone
- Suppression du `AppModule` (n'est plus nécessaire)

### 3. **Mise à jour de l'approche de bootstrap**
- `main.ts` : Migration de `platformBrowserDynamic().bootstrapModule()` vers `bootstrapApplication()`
- Création du fichier `app.config.ts` pour la configuration de l'application

### 4. **Système de routage**
- `app-routing.module.ts` : Conversion en routes standalone
- Export de `appRoutes` au lieu d'un NgModule

### 5. **Configuration Jest**
- Création de `jest.config.js` avec préset Jest Angular
- Création de `setup-jest.ts` pour l'initialisation
- Suppression de `karma.conf.js`
- Suppression de `src/test.ts`
- Mise à jour de `tsconfig.spec.json` pour Jest

### 6. **Tests**
- Migration des fichiers `.spec.ts` de Jasmine vers Jest
- Mise à jour de `TestBed.configureTestingModule()` pour les composants standalone
- Changement de `declarations: [Component]` vers `imports: [Component]`

### 7. **Configuration Angular**
- Mise à jour de `angular.json` : Remplacement du builder `karma` par `jest`

## 📦 Commandes disponibles

```bash
# Démarrer le serveur de développement
npm start

# Construire pour la production
npm build

# Exécuter les tests Jest
npm test

# Exécuter les tests en mode watch
npm test:watch

# Générer un rapport de couverture
npm test:coverage
```

## 🔧 Architecture actuelle

```
front/
├── src/
│   ├── app/
│   │   ├── app.component.ts (standalone)
│   │   ├── app.component.html
│   │   ├── app.component.scss
│   │   ├── app.component.spec.ts
│   │   ├── app-routing.module.ts (routes standalone)
│   │   ├── app.config.ts (nouvelle configuration)
│   │   └── pages/
│   │       └── home/
│   │           ├── home.component.ts (standalone)
│   │           ├── home.component.html
│   │           ├── home.component.scss
│   │           └── home.component.spec.ts
│   ├── main.ts (utilise bootstrapApplication)
│   ├── index.html
│   ├── polyfills.ts
│   ├── styles/
│   │   └── styles.scss
│   └── environments/
│       ├── environment.ts
│       └── environment.prod.ts
├── angular.json
├── jest.config.js (nouveau)
├── setup-jest.ts (nouveau)
├── tsconfig.json
├── tsconfig.app.json
├── tsconfig.spec.json
└── package.json
```

## 🎯 Prochaines étapes recommandées

1. Exécuter `npm test` pour vérifier que Jest fonctionne correctement
2. Exécuter `npm start` pour démarrer l'application
3. Ajouter d'autres composants/services en utilisant la syntaxe standalone
4. Configurer les plugins ESLint Angular pour Angular 20

## 📝 Notes importantes

- L'application utilise maintenant l'approche **standalone** recommandée par Angular 20
- Plus besoin de NgModule déclarés pour les composants
- Jest offre une meilleure performance que Karma pour les tests unitaires
- Les animations et Material sont importés directement dans les composants qui les utilisent

