#!/bin/bash

# --- CONFIGURAÇÃO ---
# Nome do banco de dados
DB_NAME= "GerenciadorPsicologico;"
# Credenciais do usuário administrador criado no MySQL
DB_USER="admin_user"
DB_PASS="senha_admin"
# Diretório onde os backups serão armazenados
BACKUP_DIR="/home/user/backup"
# Pega a data atual no formato YYYY-MM-DD
DATE=$(date +%F)
# Nome do arquivo de backup
FILE_NAME="${DB_NAME}_${DATE}.sql"

# --- GARANTE QUE O DIRETÓRIO EXISTE ---
mkdir -p "${BACKUP_DIR}"
#!/bin/bash

# --- VARIÁVEIS NECESSÁRIAS ---
DB_USER="seu_usuario"
DB_PASS="sua_senha"
DB_NAME="GerenciadorPsicologico"
BACKUP_DIR="/caminho/para/backup"
FILE_NAME="backup_gerenciador_$(date +%Y%m%d_%H%M%S).sql"

# --- FAZ O DUMP (EXPORTA) DO BANCO ---
mysqldump -u "${DB_USER}" -p"${DB_PASS}" "${DB_NAME}" > "${BACKUP_DIR}/${FILE_NAME}"

if [ $? -eq 0 ]; then
  echo "[$(date)] Backup do banco '${DB_NAME}' salvo em ${BACKUP_DIR}/${FILE_NAME}"
else
  echo "[$(date)] ERRO ao fazer backup do banco '${DB_NAME}'" >&2
  exit 1
fi

# --- RESTAURAÇÃO EXEMPLO (se precisar) ---
# Para restaurar um backup, use:
# mysql -u "${DB_USER}" -p"${DB_PASS}" "${DB_NAME}" < "${BACKUP_DIR}/${FILE_NAME}"

# --- AGENDAMENTO NO CRON ---
# Para agendar execução diária às 2h da manhã, adicione esta linha no crontab (use `crontab -e`):
# 0 2 * * * /caminho/para/backup/backup_gerenciador.sh >> /caminho/para/backup/backup.log 2>&1



