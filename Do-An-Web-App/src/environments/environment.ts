// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

import {LABEL} from '../app/config/labels';

export const environment = {
  production: false,
  client: {
    id: 'Hiep-GTVT',
    secret: 'abc@123456'
  },
  server: 'http://localhost:8080',
  label: LABEL,
  api_path: {
    auth: '/api/oauth/token',
    user: '/api/user',
    category: '/api/category'
  },
  prefix: {
    auth_header_basic: 'Basic',
    auth_header_bearer: 'Bearer',
    storage: {
      access_token: 'access_token',
      refresh_token: 'refresh_token',
      expire_access_token: 'EXP-AT',
      expire_refresh_token: 'EXP-RT',
      username: 'username',
      password: 'password'
    }
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
