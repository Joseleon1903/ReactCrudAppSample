
select * from profile

update profile set wallet_id = 1 where id = 'admin19'

select * from wallet

INSERT INTO public.wallet(
	id, account_name, account_number, balance, currency, uuid, profile_id)
	VALUES (1, 'admin-0090','admin-0090' , 200, 'USD', '6530eb23c9e72013e5b65999', 'admin19');

