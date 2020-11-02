/* client_secret column is set as the encrypted value of "secret" - the password for the clients  */
DELETE FROM oauth_client_details;
INSERT INTO oauth_client_details
	(client_id, resource_ids, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('Hiep-GTVT', 'app-api', '$2a$10$wsoNtGBi.awwcDqyGnen7.4Y5TQk5RPc2Bm6JEnEx3G0qrQts133e', 'read,write',
	'password,authorization_code,refresh_token,implicit,client_credentials', null, null, 36000, 36000, null, true);
